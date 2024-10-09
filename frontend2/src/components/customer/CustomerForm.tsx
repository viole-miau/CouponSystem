import { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Customer from "../models/Customer";
import { InputAdornment, IconButton } from "@mui/material";
import { Visibility, VisibilityOff } from "@mui/icons-material";

export default function CustomerForm() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isShowPassword, setIsShowPassword] = useState(false);
  const [customer, setCustomer] = useState<Customer>();

  useEffect(() => {
    setCustomer(new Customer(firstName, lastName, email, password));
  }, [firstName, lastName, email, password]);

  function handleClickShowPassword() {
    setIsShowPassword(!isShowPassword);
  }

  return (
    <Box
      component="form"
      sx={{ "& .MuiTextField-root": { m: 1, width: "25ch" } }}
      noValidate
      autoComplete="off"
    >
      <div>
        <TextField
          required
          id="firstName"
          label="First Name"
          variant="outlined"
          onChange={(e) => setFirstName(e.target.value)}
        />
        <TextField
          required
          id="lastName"
          label="Last Name"
          variant="outlined"
          onChange={(e) => setLastName(e.target.value)}
        />
        <TextField
          required
          id="email"
          label="Email"
          variant="outlined"
          inputMode="email"
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextField
          required
          label="Password"
          variant="outlined"
          type={isShowPassword ? "text" : "password"}
          onChange={(e) => setPassword(e.target.value)}
          slotProps={{
            input: {
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton
                    onClick={handleClickShowPassword}
                    onMouseDown={(e) => e.preventDefault()}
                    onMouseUp={(e) => e.preventDefault()}
                    aria-label="toggle password visibility"
                    edge="end"
                  >
                    {isShowPassword ? <VisibilityOff /> : <Visibility />}
                  </IconButton>
                </InputAdornment>
              ),
            },
          }}
        />
      </div>
    </Box>
  );
}
