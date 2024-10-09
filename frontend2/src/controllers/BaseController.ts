import axios, { AxiosInstance } from "axios";

export const baseController = axios.create({
  baseURL: "https://localhost:8080/api/",
  headers: {
    "Access-Control-Allow-Origin": "*",
  },
});

class BaseController {
  public instance: AxiosInstance;

  constructor(urlExtension: string | null) {
    const baseUrl: string = `http://localhost:8080/api/${urlExtension}`;
    // const headers: { [key: string]: string } = {
    //     "Access-Control-Allow-Origin": "*"
    // }
    this.instance = axios.create({
      baseURL: baseUrl,
      // headers: headers
    });
  }
}

export default BaseController;
