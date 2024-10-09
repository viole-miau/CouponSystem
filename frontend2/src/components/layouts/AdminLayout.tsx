import { NavLink, Outlet } from "react-router-dom";
import { AppBar, IconButton, Toolbar, Typography } from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import { Logout } from "@mui/icons-material";

export default function AdminLayout() {
  return (
    <>
      <AppBar position="sticky">
        <Toolbar
          sx={{
            flexGrow: 1,
          }}
        >
          <IconButton edge="start" color="secondary">
            <MenuIcon />
          </IconButton>
          <Typography variant="h5" sx={{ flexGrow: 1 }}>
            Coupon System
          </Typography>
          <Typography>
            <NavLink to="/">Home</NavLink>
          </Typography>
          <Typography>
            <NavLink to="/admin/company">Company</NavLink>
          </Typography>
          <Typography>
            <NavLink to="/admin/customer">Customer</NavLink>
          </Typography>
          <IconButton edge="end" color="secondary">
            <Logout />
          </IconButton>
        </Toolbar>
      </AppBar>
      <main>
        <Outlet />
      </main>
    </>
  );
}
