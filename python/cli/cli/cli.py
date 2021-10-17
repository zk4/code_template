#coding: utf-8

from loguru import logger
import argparse
import sys

logger.level('DEBUG')
def feed(count):
    logger.info(f"args {count}")
    logger.debug("debug")
    logger.critical("critical")
    logger.error("error")
    return count * 2

def main(args):
    ret = feed(args.count)

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
    # eat_parser.add_argument("ids",  help="usage: cli ids" )
    parser.add_argument('integers', metavar='N', type=str, nargs='*',
                        help='an integer for the accumulator')

    return parser
