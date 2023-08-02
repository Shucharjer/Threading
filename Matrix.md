对于矩阵$A=(a_{ij})_{m×s}$与矩阵$B=(b_{ij})_{s×n}$的乘积矩阵

$AB=C=(c_{ij})_{m×n}$，若把$A$按行分成$m$块，把$B$按列分成$n$块，便有
$$ AB= \left\{\begin{aligned} a^T_1\\a^T_2\\.\\.\\.\\a^T_m \end{aligned}\right\} (b_1\ \ b_2\ \ ...\ \ b_n)= \left\{\begin{aligned} a^T_1b_1\ \ a^T_1b_2\ \ ...\ a^T_1b_n\ \ a^T_2b_1\ \ a^T_2b_2\ \ ...a^T_2b_n\ ......\ \ a^T_mb_1\ \ a^T_mb_2\ \ ...\ \ a^T_mb_n \end{aligned}\right\} =(c*{ij})*{m×n}\ \\*其中 c*{ij}=a^T_ib_j=(a_{i1}\ \ a_{i2}\ \ ...\ \ a_{is}) \left\{\begin{aligned} b_{1j}\ b_{2j}...b_{sj} \end{aligned}\right\} =\sum_{k=1}^sa_{ik}b_{kj}$$
