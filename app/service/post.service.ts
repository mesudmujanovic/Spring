import { Injectable } from '@angular/core';
import { BASE_URL } from '../configs/urls.config';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from '../interface/postInterface';

@Injectable({
  providedIn: 'root'
})
export class PostService {

private apiServerUrl = BASE_URL;

constructor(private http:HttpClient) { }

public addPost(post: Post): Observable <Post> {
 return this.http.post<Post>(`${this.apiServerUrl}/api/save`,post);
}
}
