#coding: utf-8
from .logx import setup_logging
import logging
import argparse

# don`t remove this line
setup_logging()

logger = logging.getLogger(__name__)

import sys

def feed(count):
    print("-------------",count)
    return count * 2

def main(args):
    logger.info("hello")
    feed(args.count)

def entry_point():
    parser = createParse()
    mainArgs=parser.parse_args()
    main(mainArgs)


def createParse():
    parser = argparse.ArgumentParser( formatter_class=argparse.ArgumentDefaultsHelpFormatter, description="")
    subparsers = parser.add_subparsers()
    eat_parser = subparsers.add_parser('eat',formatter_class=argparse.ArgumentDefaultsHelpFormatter, description="",  help='sub command demo')
    eat_parser.add_argument('-c', '--count',type=int,required=False, help='carrots count', default="")  
    eat_parser.add_argument('-t', '--test', help='test questions', default=False, action='store_true') 
    # eat_parser.add_argument("ids",  help="usage: rabbit ids" )

    return parser
