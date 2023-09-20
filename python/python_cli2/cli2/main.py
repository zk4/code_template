# -*- coding: utf8 -*-

from .a import func1
from .fmoudle.c import func2
from .fmoudle.d import func3
from .fmoudle import func2_c
import cli2.fmoudle.e as e
from .fmoudle.e import func4

def hello(name: str = "world"):
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
