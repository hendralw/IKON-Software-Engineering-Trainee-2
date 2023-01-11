import axios from 'axios'
import { showTodo } from '../store/todo'

export async function getTodos(dispatch) {
    try {
        const response = await axios.get("https://jsonplaceholder.typicode.com/todos");

        dispatch(showTodo(response.data.slice(0, 5)));
    } catch (error) {
        console.log(error)
    }
}