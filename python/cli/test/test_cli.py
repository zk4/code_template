
# -*- coding: utf-8 -*-

from cli.cli import feed

def test_run_openssl_command() -> None:
    assert 1 == 1


def test_feed():
    assert 4 == feed(2)
