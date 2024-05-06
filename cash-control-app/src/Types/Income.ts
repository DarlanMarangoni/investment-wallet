import { Receive } from './Receive';

export interface Income {
  id: number;
  userId: string;
  name: string;
  receiveList: Receive[];
}