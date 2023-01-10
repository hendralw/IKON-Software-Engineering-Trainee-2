import { createSlice } from "@reduxjs/toolkit"

let nextId = 4;
const initialState = {
    lists:
        [
            {
                id: 1,
                title: "Mengerjakan Exercice",
                isComplete: false
            },
            {
                id: 2,
                title: "Mengerjakan Assesment",
                isComplete: false
            },
            {
                id: 3,
                title: "Implement React Redux",
                isComplete: false
            },
        ],
}

export const todoSlice = createSlice({
    name: "todo",
    initialState,
    reducers: {
        addTodo: (state, { payload }) => {
            state.lists.push({
                id: nextId++,
                title: payload,
                isComplete: false
            })

            //other way
            // state.lists = [...state.lists,
            // {
            //     id: nextId++,
            //     title: payload,
            //     isComplete: false
            // }]
        },
        removeTodo: (state, { payload }) => {
            state.lists = state.lists.filter((x) => x.id !== payload)
        },
        editTodo: (state, { payload }) => {
            state.lists = state.lists?.map((x) => {
                if (x.id === payload.id) {
                    return { ...x, isComplete: payload.isComplete }
                } else {
                    return x
                }
            })
        }
    }
})

export const { addTodo, removeTodo, editTodo } = todoSlice.actions
export default todoSlice.reducer
