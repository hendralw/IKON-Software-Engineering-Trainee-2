import { createSlice } from "@reduxjs/toolkit"

const initialState = {
    lists: [],
}

export const todoSlice = createSlice({
    name: "todo",
    initialState,
    reducers: {
        addTodo: (state, { payload }) => {
            state.lists = [payload, ...state.lists];
        },
        removeTodo: (state, { payload }) => {
            state.lists = state.lists.filter((x) => x.id !== payload)
        },
        editTodo: (state, { payload }) => {
            state.lists = state.lists?.map((x) => {
                if (x.id === payload.id) {
                    return { ...x, completed: payload.completed }
                } else {
                    return x
                }
            })
        },
        showTodo: (state, { payload }) => {
            state.lists = [...payload]
        }
    }
})

export const { addTodo, removeTodo, editTodo, showTodo } = todoSlice.actions
export default todoSlice.reducer
