# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "A JSON RPC project"
HOMEPAGE = "https://github.com/chenpc/larva"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=60d50cef7ec277df5d5e7937ffd9053b"

SRC_URI = "git://github.com/chenpc/larva;protocol=https"

# Modify these as desired
PV = "0.0.1+git${SRCPV}"
SRCREV = "0cc2906715140b655e1c64129cd7660369937f41"

S = "${WORKDIR}/git"

inherit setuptools3

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS_${PN} += "python3-decorator python3-flask python3-flask-httpauth python3-gevent gunicorn python3-dateutil python3-pam python3-sqlalchemy python3-ctypes"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python3-core"
