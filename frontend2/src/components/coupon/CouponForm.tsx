import { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Coupon from "../../models/Coupon";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";

export default function CouponForm() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [startDate, setStartDate] = useState<Date>();
  const [endDate, setEndDate] = useState<Date>();
  const [amount, setAmount] = useState(0);
  const [price, setPrice] = useState(0);

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
          id="title"
          label="Title"
          variant="outlined"
          onChange={(e) => setTitle(e.target.value)}
        />
        <TextField
          required
          id="description"
          label="Description"
          variant="outlined"
          onChange={(e) => setDescription(e.target.value)}
        />

        <TextField
          required
          id="price"
          label="Price"
          variant="outlined"
          type="number"
          onChange={(e) => {
            const targetValue = e.target.value;
            setPrice(Number(targetValue));
          }}
        />
        <TextField
          required
          id="amount"
          label="Amount"
          variant="outlined"
          type="number"
          onChange={(e) => {
            const targetValue = e.target.value;
            setPrice(Number(targetValue));
          }}
        />

        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <DatePicker
            label="Start Date"
            onChange={(e) => {
              const date = e?.toDate();
              console.log(date);
              setStartDate(date);
            }}
          />
        </LocalizationProvider>

        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <DatePicker
            label="End Date"
            onChange={(e) => {
              const date = e?.toDate();
              console.log(date);
              setEndDate(date);
            }}
          />
        </LocalizationProvider>
      </div>
    </Box>
  );
}
