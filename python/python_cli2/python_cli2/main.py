# -*- coding: utf8 -*-

def hello(name: str = "world"):
    return f"hello {name} ."

if __name__ == "__main__":
    print(hello())
    print(hello("python"))
