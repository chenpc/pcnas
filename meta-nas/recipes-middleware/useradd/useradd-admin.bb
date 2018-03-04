SUMMARY = "Example recipe for using inherit useradd"
DESCRIPTION = "This recipe serves as an example for using features from useradd.bbclass"
SECTION = "examples"
PR = "r1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SRC_URI = "file://tmux.conf"
S = "${WORKDIR}"


EXCLUDE_FROM_WORLD = "1"

inherit useradd

# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN}"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.

# USERADD_PARAM specifies command line options to pass to the
# useradd command. Multiple users can be created by separating
# the commands with a semicolon. Here we'll create two users,
# user1 and user2:
USERADD_PARAM_${PN} = "-u 1000 -d /home/admin -r -s /usr/bin/commandcenter -P 'admin' admin"


# GROUPADD_PARAM works the same way, which you set to the options
# you'd normally pass to the groupadd command. This will create
# groups group1 and group2:
GROUPADD_PARAM_${PN} = "-g 100 users"

do_install () {
	install -d -m 755 ${D}/home/admin
	install -p -m 644 tmux.conf ${D}/home/admin/.tmux.conf

	# The new users and groups are created before the do_install
	# step, so you are now free to make use of them:
	chown -R admin ${D}/home/admin
	chgrp -R admin ${D}/home/admin
}

FILES_${PN} = "/home/admin"

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
