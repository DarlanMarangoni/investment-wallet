import axios from 'axios';

export interface Income {

}

export const findAllByUser = () => axios.get<any>(`http://localhost:8081/api/incomes?userId=8ca161e7-a3d6-4275-9193-32a7adfdb9a6`);