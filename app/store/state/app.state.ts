import { PostOrderState, initialPostOrderState, } from './select.state';


export interface AppState {
    order: PostOrderState;
}

export const initalAppState: AppState = {
    order: initialPostOrderState,
}

export function getInitalState(): AppState {
    return initalAppState;
}