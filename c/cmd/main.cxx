
typedef struct {
  int a;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
}A;
int main()
{
  A a ;
  A* c=&a;
  A* b=&a;
  A* d=&a;
  a.a  =111;
  a.b  =222;
  a.c  =333;
  a.d  =444;
  a.e  =555;
  a.f  =666;
  a.g  =777;
  c->a  =5555;
  c->b  =444;
  c->a  =5555;
  c->b  =444;
  return 0;
}
