# -*- coding: utf8 -*-
from cli2.main import hello

import sys
print(sys.path,flush=True)

from cli2.module1.e import func4

def test_func4():
    assert func4()==4

def test_hello():
    assert hello() == "hello world ."
