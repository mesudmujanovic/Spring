import { SelectedPostActions, _SelectedPost } from '../action/action';
import { PostOrderState, initialPostOrderState } from '../state/select.state';

export const postOrderReducers = (
    state = initialPostOrderState,
    action: SelectedPostActions
): PostOrderState => {
    switch(action.type){
        case _SelectedPost.AddPost:
            return{
                ...state,
                post:action.payload,
            };
            default:
                return state;

    }
}