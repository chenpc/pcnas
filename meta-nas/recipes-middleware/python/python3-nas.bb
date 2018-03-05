SUMMARY = "A NAS middleware deamon"
HOMEPAGE = "https://github.com/chenpc/python-nas"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/chenpc/python-nas;protocol=https \
	file://nas.service"

PV = "0.0.1+git${SRCPV}"
SRCREV = "d407b1270b6b86b37370697a93b10d14e19a49bf"

S = "${WORKDIR}/git"

inherit setuptools3 systemd

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
SYSTEMD_SERVICE_${PN} = "nas.service"
SYSTEMD_PACKAGES ?= "${PN}"
RDEPENDS_${PN} += "python3-larva python3-sqlite3 python3-pyudev python3-requests dmidecode libudev"
RDEPENDS_${PN} += "python3-psutil lvm2 util-linux-lsblk rsyslog lshw python3-prompt-toolkit useradd-admin"
RDEPENDS_${PN} += "parted util-linux-umount e2fsprogs-mke2fs vlan attr acl python3-pygobject python3-networkmanager"
do_install_append () {
	install -d ${D}/etc/rsyslog.d
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/nas.service ${D}${systemd_unitdir}/system
}

