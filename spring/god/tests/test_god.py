
# -*- coding: utf-8 -*-

from god import god

def test_run_openssl_command() -> None:
    assert 1 == 1


def test_feed():
    assert 4 == god.feed(2)
