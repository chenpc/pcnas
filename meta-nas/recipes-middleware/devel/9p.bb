SUMMARY = "Mount 9PFS in development environment"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://9p.service"
inherit systemd
SYSTEMD_SERVICE_${PN} = "9p.service"
SYSTEMD_PACKAGES ?= "${PN}"

do_install () {
	install -d -m 755 ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/9p.service ${D}${systemd_unitdir}/system/9p.service
}
