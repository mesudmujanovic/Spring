import { Component } from '@angular/core';
import { Post } from 'src/app/interface/postInterface';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {

  postForm:FormGroup;

  constructor(private formBuilder:FormBuilder,private postService:PostService){}

  ngOnInit():void{
  this.postForm = this.formBuilder.group({
    title:['',Validators.required],
    description:['',Validators.required]
  });
  }

  onSubmit() {
    this.postService.addPost(this.postForm.value).subscribe(
      (response: Post) => {
        console.log(response);
      },
      (error: any) => {
        console.log(error);
      }
    );
  }
  
  

}
