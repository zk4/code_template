# -*- coding: utf8 -*-
from python_cli2.main import hello

import sys
print(sys.path,flush=True)

def test_hello():
    assert hello() == "hello world ."
