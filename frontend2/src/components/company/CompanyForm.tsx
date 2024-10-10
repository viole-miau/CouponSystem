import { useEffect, useState } from "react";
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
import { useNavigate, useParams } from "react-router-dom";
import { getCompany } from "../../controllers/adminController";

type CompanyFormProps = {
  onSubmit: (company: Company) => Promise<boolean>;
};

export default function CompanyForm(props: CompanyFormProps) {
  const { id } = useParams();
  const navigate = useNavigate();

  const [companyId, setCompanyId] = useState<number>();
  const [companyName, setCompanyName] = useState("");
  const [companyNameError, setCompanyNameError] = useState(false);
  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState(false);
  const [password, setPassword] = useState("");
  const [passwordError, setPasswordError] = useState(false);
  const [isShowPassword, setIsShowPassword] = useState(false);
  const [isPending, setIsPending] = useState(false);
  const [isEdit, setIsEdit] = useState(false);
  const [companyToEdit, setCompanyToEdit] = useState<Company>(
    Company.emptyCompany()
  );

  useEffect(() => {
    if (id) {
      getCompany(Number(id))
        .then((company) => {
          setIsEdit(true);
          setCompanyId(company.id);
          setCompanyName(company.name);
          setEmail(company.email);
          setPassword(company.password);
          setCompanyToEdit(company);
        })
        .catch((err) => console.error(err));
    }
  }, []);

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
      const company = isEdit
        ? new Company({
            id: companyId,
            name: companyName,
            email,
            password,
          })
        : new Company({
            name: companyName,
            email,
            password,
          });
      setIsPending(true);
      props
        .onSubmit(company)
        .then((res) => {
          if (res) {
            navigate({ pathname: "/admin/company" });
          } else {
            console.error("Failed to submit");
          }
        })
        .catch((err) => console.error(err))
        .finally(() => setIsPending(false));
    }
  }

  return (
    <>
      <form autoComplete="false" noValidate onSubmit={handleSubmit}>
        <Paper>
          {isEdit ? (
            <TextField
              required
              id="companyName"
              label="Company Name"
              variant="outlined"
              error={companyNameError}
              defaultValue={companyToEdit.name}
              value={companyName}
              onChange={(e) => setCompanyName(e.target.value)}
            />
          ) : (
            <TextField
              required
              id="companyName"
              label="Company Name"
              variant="outlined"
              error={companyNameError}
              onChange={(e) => setCompanyName(e.target.value)}
            />
          )}
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
          <Button
            variant="contained"
            color="secondary"
            type="submit"
            disabled={isPending}
          >
            <Typography variant="body1">Submit</Typography>
          </Button>
        </Paper>
      </form>
    </>
  );
}
