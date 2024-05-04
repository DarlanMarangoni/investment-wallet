import './style.css';
import Box from '@mui/material/Box';
import { FormControl, InputAdornment, InputLabel, Select, SelectChangeEvent, TextField } from '@mui/material';
import React, { useEffect, useState } from 'react';
import MenuItem from '@mui/material/MenuItem';
import Button from '@mui/material/Button';
import CustomTable from '../../components/CustomTable';
import { findAllByUser } from '../../services/IncomeService';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';

interface ReceiveRequest {
    projected: number,
    actual: number,
    date: string
}

export default function IncomePage() {

    const [incomeType, setIncomeType] = useState('');
    const [incomeName, setIncomeName] = useState('');
    const [txtPrevisto, setTxtPrevisto] = useState('');
    const [txtRealizado, setTxtRealizado] = useState('');
    const [data, setData] = useState('');
    const [incomes, setIncomes] = useState([]);


    function handleChangeIncomeType(event: SelectChangeEvent) {
        setIncomeType(event.target.value)
    }

    function handleChangeIncomeName(event: SelectChangeEvent) {
        setIncomeName(event.target.value)
    }

    useEffect(() => {
        findAllByUser()
            .then(response => {
                setIncomes(response.data.map((m: any) =>
                    <MenuItem key={m.id} value={m.name}>{m.name}</MenuItem>
                ));
            })
            .catch(error => console.error(error))
    }, []);

    function handleClick(event: any) {
        event.preventDefault();
        const request: ReceiveRequest = {
            projected: parseFloat(txtPrevisto),
            actual: parseFloat(txtRealizado),
            date: data
        }
        console.log(request)
    }

    function handleInputTextPrevisto(event: any) {
        setTxtPrevisto(event.target.value)
    }

    function handleInputTextRealizado(event: any) {
        setTxtRealizado(event.target.value);
    }

    function handleDatePicker(event: any) {
        const data = new Date(event.$d);
        const ano = data.getFullYear();
        const mes = (data.getMonth() + 1).toString().padStart(2, '0'); // O mês é base zero, por isso adicionamos 1
        const dia = data.getDate().toString().padStart(2, '0');
        setData(`${ano}-${mes}-${dia}`)
    }

    return (
        <Box
            component="form"
            noValidate
            autoComplete="off"
        >
            <div>
                <div style={{display: 'flex', justifyContent: 'center'}}>
                    <h1>Cadastro de Receitas Mensais</h1>
                </div>
                <div style={{display: 'flex', justifyContent: 'space-between'}}>
                    <FormControl sx={{m: 1, minWidth: 252}}>
                        <InputLabel id="income-name-select-label">Descrição</InputLabel>
                        <Select
                            labelId="income-name-select-label"
                            id="income-name-select"
                            value={incomeName}
                            label="Descrição"
                            onChange={handleChangeIncomeName}
                        >
                            {incomes}
                        </Select>
                    </FormControl>
                    <TextField
                        label="Valor Previsto"
                        id="txtField-valor-previsto"
                        sx={{m: 1, width: '25ch'}}
                        InputProps={{
                            startAdornment: <InputAdornment position="start">R$</InputAdornment>
                        }}
                        type="number"
                        value={txtPrevisto}
                        onChange={handleInputTextPrevisto}
                    />
                    <TextField
                        label="Valor Realizado"
                        id="txtField-valor-realizado"
                        sx={{m: 1, width: '25ch'}}
                        InputProps={{
                            startAdornment: <InputAdornment position="start">R$</InputAdornment>
                        }}
                        type="number"
                        value={txtRealizado}
                        onChange={handleInputTextRealizado}
                    />
                    <LocalizationProvider dateAdapter={AdapterDayjs} >
                        <DatePicker sx={{margin: '8px', minWidth: 252}} onChange={handleDatePicker}/>
                    </LocalizationProvider>
                </div>
                <div style={{margin: '8px'}}>
                    <Button variant="contained" size="medium" onClick={handleClick}>Adicionar</Button>
                </div>
                <div className="table">
                    <CustomTable/>
                </div>
            </div>
        </Box>
    );
}