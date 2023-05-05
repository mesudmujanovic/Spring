import { Action } from "@ngrx/store";
import { Post } from "../interface/selected";



export enum _SelectedPost{
    AddPost = '[SelectedOrder] Add Post',
}

export class AddPost implements Action{
    public readonly type = _SelectedPost.AddPost;
    constructor(public payload:Post[]){}
}

export type SelectedPostActions = AddPost