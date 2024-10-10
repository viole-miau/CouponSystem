import { useState, useEffect } from "react";
import TextField from "@mui/material/TextField";
import Company from "../../models/Company";
import {
  InputAdornment,
  IconButton,
  Button,
  Paper,
  Typography,
} from "@mui/material";
import { Visibility, VisibilityOff } from "@mui/icons-material";
import { useParams } from "react-router-dom";

type CompanyFormProps = {
  onSubmit: (company: Company) => Promise<boolean>;
};

export default function CompanyForm(props: CompanyFormProps) {
  const { companyId } = useParams();

  const [companyName, setCompanyName] = useState("");
  const [companyNameError, setCompanyNameError] = useState(false);
  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState(false);
  const [password, setPassword] = useState("");
  const [passwordError, setPasswordError] = useState(false);
  const [isShowPassword, setIsShowPassword] = useState(false);

  function handleClickShowPassword() {
    setIsShowPassword(!isShowPassword);
  }

  function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (!companyName) {
      setCompanyNameError(true);
    }
    if (!email) {
      setEmailError(true);
    }
    if (!password) {
      setPasswordError(true);
    }
    if (companyName && email && password) {
      const company = new Company({
        name: companyName,
        email,
        password,
      });
      props
        .onSubmit(company)
        .then((res) =>
          res
            ? console.log("Succesfully entered company")
            : console.log("Failed to submit company")
        )
        .catch((err) => console.error(err));
    }
  }

  return (
    <>
      <form autoComplete="false" noValidate onSubmit={handleSubmit}>
        <Paper>
          <TextField
            required
            id="companyName"
            label="Company Name"
            variant="outlined"
            error={companyNameError}
            onChange={(e) => setCompanyName(e.target.value)}
          />
          <TextField
            required
            id="companyEmail"
            label="Email"
            variant="outlined"
            inputMode="email"
            error={emailError}
            onChange={(e) => setEmail(e.target.value)}
          />
          <TextField
            required
            label="Password"
            variant="outlined"
            type={isShowPassword ? "text" : "password"}
            error={passwordError}
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
          <Button variant="contained" color="secondary" type="submit">
            <Typography variant="body1">Submit</Typography>
          </Button>
        </Paper>
      </form>
    </>
  );
}
