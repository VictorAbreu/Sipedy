import { Role } from 'type/role';

export type User = {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  celular: string;
  cpf: string;
  roles: Role[];
};
