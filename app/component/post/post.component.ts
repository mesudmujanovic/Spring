import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { Store } from '@ngrx/store';
import { Observable, Subject, catchError, from, mergeMap, of, switchMap, takeUntil, tap, throwError } from 'rxjs';
import { Post } from 'src/app/interface/interface.post';
import { PostService } from 'src/app/service/post.service';
import { AddPost } from 'src/app/store/action/action';
import { getPostSelector } from 'src/app/store/selectors/selector';
import { AppState } from 'src/app/store/state/app.state';
@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {

  postForm: FormGroup
  posts$: Observable<Post[]>;
  private destroy$: Subject<void> = new Subject<void>();
  selectedPost$: Observable<Post> = this.store.select(getPostSelector)

  constructor(private formBuilder: FormBuilder, private postService: PostService,
    private store: Store<AppState>) { }

  ngOnInit(): void {
    this.postForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required]
    });
    this.getPost();
  }

  onSelectedPost(post: any) {
    this.store.dispatch(new AddPost(post));
    this.selectedPost$.subscribe(() => {
      console.log("select", this.selectedPost$);
    });
  }

  onSubmit() {
    this.postService.addPost(this.postForm.value).pipe(
      switchMap(() => this.getPost())
    ).subscribe(
      (response: Post[]) => {
        console.log(response);
        this.postForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  };

  onDeletePost(postId: number): void {
    if (!confirm('Are you sure you want delete this post?')) {
      return;
    }
    this.postService.deletePost(postId).pipe(
      takeUntil(this.destroy$),
      switchMap(() => this.getPost())
    ).subscribe(
      (response: Post[]) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  getPost(): Observable<Post[]> {
    return this.posts$ = this.postService.getAllPost().pipe(
      catchError(error => {
        console.log(error);
        return of([]);
      })
    );
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
