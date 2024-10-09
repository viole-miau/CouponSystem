type CompanyConstractorArguments = {
  id?: number;
  name: string;
  email: string;
  password: string;
};

class Company {
  public readonly id?: number;
  public name: string;
  public email: string;
  private _password: string;

  constructor(args: CompanyConstractorArguments) {
    this.name = args.name;
    this.email = args.email;
    this._password = args.password;
    this.id = args.id;
  }

  get password() {
    return this._password
      .split("")
      .map((char) => "*")
      .join("");
  }
}

export default Company;
