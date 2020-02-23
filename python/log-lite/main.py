#coding: utf-8
import logx
import logging
logger = logging.getLogger(__name__)

if __name__ == "__main__":
    logger = logger or logging.getLogger(__name__)

    logger.debug("debug")
    logger.info("hello cinfo")
    logger.error('error ')
    logger.warning('warning')
    logger.critical('critical')

