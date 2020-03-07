
# -*- coding: utf-8 -*-

from bestpractice import bestpractice

def test_run_openssl_command() -> None:
    assert 1 == 1


def test_feed():
    assert 4 == bestpractice.feed(2)
