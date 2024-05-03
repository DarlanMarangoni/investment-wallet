import './style.css';
import Box from '@mui/material/Box';
import { FormControl, InputAdornment, InputLabel, Select, SelectChangeEvent, TextField } from '@mui/material';
import React, { useState } from 'react';
import MenuItem from '@mui/material/MenuItem';
import Button from '@mui/material/Button';
import CustomTable from '../../components/CustomTable';

export default function IncomePage() {

    const [incomeType, setIncomeType] = useState('');
    const [incomeName, setIncomeName] = useState('');

    function handleChangeIncomeType(event: SelectChangeEvent) {
        setIncomeType(event.target.value)
    }

    function handleChangeIncomeName(event: SelectChangeEvent) {
        setIncomeName(event.target.value)
    }

    return (
        <Box
            component="form"
            noValidate
            autoComplete="off"
        >
            <div>
                <div>
                    <FormControl variant="standard" sx={{m: 1, minWidth: 252}}>
                        <InputLabel id="income-type-select-label">Tipo de renda</InputLabel>
                        <Select
                            labelId="income-type-select-label"
                            id="income-type-select"
                            value={incomeType}
                            onChange={handleChangeIncomeType}
                        >
                            <MenuItem value={"ACTIVE_INCOME"}>Renda Ativa</MenuItem>
                            <MenuItem value={"PASSIVE_INCOME"}>Renda Passiva</MenuItem>
                        </Select>
                    </FormControl>
                    <FormControl variant="standard" sx={{m: 1, minWidth: 252}}>
                        <InputLabel id="income-name-select-label">Descrição</InputLabel>
                        <Select
                            labelId="income-name-select-label"
                            id="income-name-select"
                            value={incomeName}
                            onChange={handleChangeIncomeName}
                        >
                            <MenuItem value={"Salario"}>Salario</MenuItem>
                            <MenuItem value={"Dividendo"}>Dividendo</MenuItem>
                        </Select>
                    </FormControl>
                    <TextField
                        label="Valor Previsto"
                        id="txtField-valor-previsto"
                        sx={{m: 1, width: '25ch'}}
                        InputProps={{
                            startAdornment: <InputAdornment position="start">R$</InputAdornment>
                        }}
                        variant="standard"
                        type="number"
                    />
                    <TextField
                        label="Valor Realizado"
                        id="txtField-valor-realizado"
                        sx={{m: 1, width: '25ch'}}
                        InputProps={{
                            startAdornment: <InputAdornment position="start">R$</InputAdornment>
                        }}
                        variant="standard"
                        type="number"
                    />
                </div>
                <div style={{margin: '8px'}}>
                    <Button variant="contained" size="medium">Adicionar</Button>
                </div>
                <div className="table">
                    <CustomTable/>
                </div>
            </div>
        </Box>
    );
}