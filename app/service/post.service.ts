import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BASE_URL } from '../configs/urls.config';
import { Observable } from 'rxjs';
import { Post } from '../interface/interface.post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private apiBaseUrl = BASE_URL;

  constructor(private http:HttpClient) { }
  
  public addPost(post:Post): Observable<Post>{
    return this.http.post<Post>(`${this.apiBaseUrl}/api/save`,post);
  }

  public getAllPost(): Observable<Post[]>{
    return this.http.get<Post[]>(`${this.apiBaseUrl}/api/posts`);
  }

  public deletePost(postId:number): Observable<void>{
    return this.http.delete<void>(`${this.apiBaseUrl}/api/post/${postId}`);
  }

}
