import { ActionReducerMap } from "@ngrx/store";
import { AppState } from "../state/app.state";
import { postOrderReducers } from "./reducers";

export const appReducers: ActionReducerMap<AppState, any> = {
    order: postOrderReducers
}