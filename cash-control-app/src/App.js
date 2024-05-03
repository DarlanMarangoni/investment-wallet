import NavBar from './components/NavBar';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomePage from "./pages/HomePage";
import ExpensePage from "./pages/ExpensePage";
import IncomePage from "./pages/IncomePage";
import Container from "@mui/material/Container";

function App() {
    return (<>
            <BrowserRouter>
                <NavBar/>
                <Container>
                    <Routes>
                        <Route path="/home" element={<HomePage/>}/>
                        <Route path="/income" element={<IncomePage/>}/>
                        <Route path="/expense" element={<ExpensePage/>}/>
                    </Routes>
                </Container>
            </BrowserRouter>
        </>);
}

export default App;
