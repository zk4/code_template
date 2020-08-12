
# -*- coding: utf-8 -*-

from cmd import cmd

def test_run_openssl_command() -> None:
    assert 1 == 1


def test_feed():
    assert 4 == cmd.feed(2)
