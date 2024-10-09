import { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Company from "../../models/Company";
import { InputAdornment, IconButton, Button } from "@mui/material";
import { Visibility, VisibilityOff } from "@mui/icons-material";

type CompanyFormParams = {
  company?: Company;
  onSubmit: (Company: Company) => void;
};

export default function CompanyForm(params: CompanyFormParams) {
  const [companyName, setCompanyName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isShowPassword, setIsShowPassword] = useState(false);
  const [company, setCompany] = useState<Company>();

  useEffect(() => {
    if (params.company) {
      setCompany(params.company);
    }
  }, [params.company]);

  useEffect(() => {
    setCompany(new Company({ name: companyName, email, password }));
  }, [companyName, email, password]);

  function handleClickShowPassword() {
    setIsShowPassword(!isShowPassword);
  }

  function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (company) {
      params.onSubmit(company);
    } else {
      console.error("company cannot be null");
    }
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
          id="companyName"
          label="Company Name"
          variant="outlined"
          onChange={(e) => setCompanyName(e.target.value)}
        />
        <TextField
          required
          id="companyEmail"
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
        <Button variant="contained" onClick={handleSubmit}>
          Contained
        </Button>
      </div>
    </Box>
  );
}
