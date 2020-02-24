#coding: utf-8
import logx
import logging
import mylib
logger = logging.getLogger(__name__)
logger.setLevel("CRITICAL")

if __name__ == "__main__":
    logger.debug("debug")
    logger.info("hello cinfo")
    logger.error('error ')
    logger.warning('warning')
    logger.critical('critical')


