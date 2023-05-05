import { createSelector } from "@ngrx/store";
import { AppState } from "../state/app.state";
import { PostOrderState } from "../state/select.state";


const orderSelectors = (state: AppState) => state.order;

export const getPostSelector = createSelector(
    orderSelectors,
    (state: PostOrderState) => state.post
)