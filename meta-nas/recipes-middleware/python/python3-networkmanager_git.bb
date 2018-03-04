# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Easy communication with NetworkManager"
HOMEPAGE = "http://github.com/seveas/python-networkmanager"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   COPYING
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://COPYING;md5=8d8bac174bf8422b151200e6cc78ebe4"

SRC_URI = "git://github.com/seveas/python-networkmanager;protocol=https"

# Modify these as desired
PV = "2.0.1+git${SRCPV}"
SRCREV = "aea55e82cfd888e12bb4cd7b7c4fffba1a6c09ba"

S = "${WORKDIR}/git"

inherit setuptools3

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS_${PN} += "python3-dbus networkmanager"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    dbus
#    dbus.service


