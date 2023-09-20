# -*- coding: utf8 -*-

from .a import func1
from .module1.c import func2
from .module1.d import func3
# this is module.__init__.py file
from .module1 import func2_c
import cli2.module1.e as e
import cli2
from .module1.e import func4
from .module2.f import func5,func6

def hello(name: str = "world"):
    cli2.module1.e.func4()
    func6()
    func5()
    func4()
    e.func4()
    func2_c()
    func3()
    func2()
    func1()
    return f"hello {name} ."

if __name__ == "__main__":
    #  print(hello())
    print(hello("python"))
