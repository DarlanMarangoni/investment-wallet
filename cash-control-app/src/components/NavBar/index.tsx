import { AppBar, Container, IconButton, Toolbar, Typography } from '@mui/material';
import AdbIcon from '@mui/icons-material/Adb'

export default function NavBar() {
    return (
        <AppBar position="static">
            <Container maxWidth="xl">
                <Toolbar>
                    <AdbIcon sx={{ display: {xs: 'none', md: 'flex'}, mr: 1}} />
                    <IconButton
                        size="large"
                        edge="end"
                        color="inherit"
                        aria-label="menu"
                        sx={{mr: 2}}
                    >
                    </IconButton>
                    <Typography variant="h6" component="div" sx={{flexGrow: 1}}>
                        Controle financeiro
                    </Typography>
                </Toolbar>
            </Container>
        </AppBar>
    );
}