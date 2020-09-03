TARGETS = console-setup mountkernfs.sh resolvconf hostname.sh x11-common screen-cleanup apparmor udev mountdevsubfs.sh procps hwclock.sh checkroot.sh networking urandom mountnfs-bootclean.sh mountnfs.sh bootmisc.sh checkfs.sh checkroot-bootclean.sh mountall.sh kmod mountall-bootclean.sh
INTERACTIVE = console-setup udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
procps: mountkernfs.sh udev
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
networking: mountkernfs.sh urandom resolvconf procps
urandom: hwclock.sh
mountnfs-bootclean.sh: mountnfs.sh
mountnfs.sh: networking
bootmisc.sh: mountnfs-bootclean.sh checkroot-bootclean.sh udev mountall-bootclean.sh
checkfs.sh: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
kmod: checkroot.sh
mountall-bootclean.sh: mountall.sh
