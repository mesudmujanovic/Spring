import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import{FormGroup,FormBuilder,Validators} from '@angular/forms'
import { Observable, catchError, from, of } from 'rxjs';
import { Post } from 'src/app/interface/interface.post';
import { PostService } from 'src/app/service/post.service';
@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent{

postForm:FormGroup
posts$: Observable<Post[]>;
deleteOnePost:Post;

constructor(private formBuilder:FormBuilder,private postService:PostService){}

ngOnInit():void{
  this.getPost();
  this.postForm = this.formBuilder.group({
    title:['',Validators.required],
    description:['',Validators.required]
  });
}

onSubmit(){
  this.postService.addPost(this.postForm.value).subscribe(
    (response: Post)=>{
      console.log(response);
    },
    (error:any)=>{
      console.log(error);
    }
  )
};

getPost():Observable<Post[]>{
 return this.posts$ = this.postService.getAllPost().pipe(
  catchError(error => {
    console.log(error);
    return of([]);
  })
 );
}

onDeletePost(postId:number):void{
  this.postService.deletePost(postId).subscribe(
    (response:void) =>{
     console.log(response);
     this.getPost();
    },
    (error:HttpErrorResponse) =>{
      alert(error.message);
    }
  );
}



}
