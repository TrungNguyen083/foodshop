import { Users } from './users';

describe('Users', () => {
  it('should create an instance', () => {
    expect(new Users(null,null,null,null,null,null)).toBeTruthy();
  });
});
