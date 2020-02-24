#coding: utf-8
from rabbit.logx import  *
import logging

logger = logging.getLogger(__name__)


if __name__ == "__main__":
    logger.debug("debug")
    logger.info("hello cinfo")
    logger.info("hello cinfo")
    logger.info("hello cinfo")
    logger.info("hello cinfo")
    logger.error('error ')
    logger.warning('warning')
    logger.critical('critical')


