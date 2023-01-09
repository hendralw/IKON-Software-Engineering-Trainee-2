import { useForm } from "react-hook-form";
import { useState } from "react";

export default function Form() {
    const { register, formState: { errors }, handleSubmit } = useForm();
    const onSubmit = (data) => submit(data);
    return (
        <form onSubmit={handleSubmit(onSubmit)} style={{ marginLeft: "40px", marginTop: "30px" }}>
            <div>
                <div>Nama Lengkap</div>
                <input
                    {...register("nama_lengkap", { required: true, pattern: /^[A-Za-z]+$/i })}
                    aria-invalid={errors.nama_lengkap ? "true" : "false"}
                />
                {errors.nama_lengkap?.type === 'required' && <p role="alert" style={{ color: "red" }}>Nama harus diisi</p>}
                {errors.nama_lengkap?.type === 'pattern' && <p role="alert" style={{ color: "red" }}>Nama Lengkap harus berupa huruf</p>}
            </div>

            <div>
                <div>Email</div>
                <input
                    {...register("email", { required: true, pattern: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i })}
                    aria-invalid={errors.mail ? "true" : "false"}
                />
                {errors.email?.type === "required" && <p role="alert" style={{ color: "red" }}>Email harus diisi</p>}
                {errors.email?.type === "pattern" && <p role="alert" style={{ color: "red" }}>Email tidak sesuai</p>}
            </div>

            <div>
                <div>No handphone</div>
                <input type="number" min="0"
                    {...register("no_handphone", { required: true, minLength: 10, maxLength: 13 })}
                    aria-invalid={errors.no_handphone ? "true" : "false"}
                />
                {errors.no_handphone?.type === 'required' && <p role="alert" style={{ color: "red" }}>No Handphone harus diisi</p>}
                {errors.no_handphone?.type === 'minLength' && <p role="alert" style={{ color: "red" }}>No Handphone minimal 10 angka</p>}
                {errors.no_handphone?.type === 'maxLength' && <p role="alert" style={{ color: "red" }}>No Handphone maksimal 13 angka</p>}
            </div>

            <div>Latar Belakang Pendidikan</div>
            <div style={{ marginLeft: "20px" }}>
                <div>
                    <input {...register("latar_belakang")}
                        className="form-check-input"
                        type="radio"
                        value="IT"
                        defaultChecked
                    />
                    <label className="form-check-label">
                        IT
                    </label>
                </div>

                <div>
                    <input {...register("latar_belakang")}
                        className="form-check-input"
                        type="radio"

                        value="Non IT"
                    />
                    <label className="form-check-label">
                        Non IT
                    </label>
                </div>
            </div>

            <br></br>
            <div>
                <div>Kelas Coding yang Dipilih</div>
                <select {...register("kelas_coding")}>
                    <option value="">Pilih salah satu program</option>
                    <option value="Backend Engineer">Backend Engineer</option>
                    <option value="Frontend Engineer">Frontend Engineer</option>
                    <option value="Fullstack Engineer">Fullstack Engineer</option>
                </select>
            </div>

            <br></br>
            <div>
                <div>Foto Surat Kesungguhan</div>

                <input {...register("image")} required type="file" name="image"
                />
            </div>

            <div>
                <div>Harapan untuk Coding Bootcamp ini:</div>
                <textarea {...register("harapan")} />
            </div>

            <div style={{ marginTop: "20px" }}>
                <input className="btn btn-success btn-sm" type="submit" style={{ marginRight: "10px" }} />
                <input className="btn btn-danger btn-sm" type="reset" />
            </div>

        </form >
    );

    function submit(data) {
        data.image = data.image[0].name
        console.log(JSON.stringify(data))
        alert(
            "Data pendaftar " + data.nama_lengkap + " berhasil diterima"
        )
    }
}
