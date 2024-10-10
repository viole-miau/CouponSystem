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
  private password: string;

  constructor(args: CompanyConstractorArguments) {
    this.name = args.name;
    this.email = args.email;
    this.password = args.password;
    this.id = args.id;
  }

  get passwordMasked() {
    return this.password
      .split("")
      .map((char) => "*")
      .join("");
  }
}

export default Company;
