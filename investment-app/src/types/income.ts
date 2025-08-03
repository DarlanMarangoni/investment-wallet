import { IncomeItem } from './incomeItem';

export type Income = {
    total: number;
    type: string;
    variable_income_item_record_list: IncomeItem[]
}