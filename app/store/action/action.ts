import { Action } from "@ngrx/store";
import { Post } from "src/app/interface/interface.post";


export enum _SelectedPost {
    AddPost = '[SelectedOrder] Add Post',
}

export class AddPost implements Action {
    public readonly type = _SelectedPost.AddPost;
    constructor(public payload: Post[]) { }
}

export type SelectedPostActions = AddPost;